import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'

function formatDateTime(value) {
  if (!value) return '—'
  const date = new Date(value)
  if (Number.isNaN(date.getTime())) return value
  return date.toLocaleString([], {
    year: 'numeric', month: 'short', day: '2-digit',
    hour: '2-digit', minute: '2-digit'
  })
}

function Dashboard() {
  const navigate = useNavigate()
  const [employee] = useState(() => {
    try { return JSON.parse(localStorage.getItem('hrmsEmployee') || 'null') }
    catch { return null }
  })
  const [attendance, setAttendance] = useState([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState('')

  useEffect(() => {
    if (!employee) {
      navigate('/login', { replace: true })
      return
    }

    async function loadAttendance() {
      try {
        const response = await fetch(`http://localhost:8080/v1/user/attendance/${employee.emp_id}`)
        if (!response.ok) throw new Error('Could not load attendance records.')
        setAttendance(await response.json())
      } catch (err) {
        setError(err.message === 'Failed to fetch'
          ? 'Cannot connect to the backend. Start the Spring Boot application and refresh.'
          : err.message)
      } finally {
        setLoading(false)
      }
    }
    loadAttendance()
  }, [employee, navigate])

  function logout() {
    localStorage.removeItem('hrmsEmployee')
    navigate('/login')
  }

  if (!employee) return null

  return (
    <main className="dashboard-page">
      <header className="dashboard-header">
        <div className="dashboard-brand"><span className="brand-mark small-mark">HRMS</span><span>Employee Portal</span></div>
        <button className="logout-button" onClick={logout}>Logout</button>
      </header>
      <section className="dashboard-content">
        <p className="eyebrow">YOUR WORKSPACE</p>
        <h1>Hello, {employee.emp_name || 'Employee'}</h1>
        <p className="muted">Here is your attendance history and daily in-time / out-time.</p>

        <section className="profile-panel">
          <div><span className="detail-label">Employee ID</span><strong>{employee.emp_id}</strong></div>
          <div><span className="detail-label">Email</span><strong>{employee.emp_email}</strong></div>
          <div><span className="detail-label">Designation</span><strong>{employee.designation || '—'}</strong></div>
          <div><span className="detail-label">Stack / Department</span><strong>{employee.stack || '—'}</strong></div>
        </section>

        <section className="attendance-section">
          <div className="section-heading">
            <div><h2>Attendance records</h2><p className="muted">Records linked to your employee ID.</p></div>
            <span className="record-count">{attendance.length} records</span>
          </div>
          {error && <p className="error-message">{error}</p>}
          {loading ? <p className="empty-state">Loading attendance...</p> :
            attendance.length === 0 && !error ? <p className="empty-state">No attendance records found for your account yet.</p> :
            attendance.length > 0 && (
              <div className="table-wrap">
                <table className="attendance-table">
                  <thead><tr><th>Date</th><th>In-time</th><th>Out-time</th><th>Comment</th></tr></thead>
                  <tbody>{attendance.map((record, index) => (
                    <tr key={record.attendanceId ?? `${record.attendancedate}-${index}`}>
                      <td>{record.attendancedate || '—'}</td>
                      <td>{formatDateTime(record.inTime)}</td>
                      <td>{formatDateTime(record.outTime)}</td>
                      <td>{record.comment || '—'}</td>
                    </tr>
                  ))}</tbody>
                </table>
              </div>
            )}
        </section>
      </section>
    </main>
  )
}

export default Dashboard
