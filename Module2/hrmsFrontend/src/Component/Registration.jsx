import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

function Registration() {
  const [empId, setEmpId] = useState('')
  const [empName, setEmpName] = useState('')
  const [empDesignation, setEmpDesignation] = useState('')
  const [empStack, setEmpStack] = useState('')
  const [empEmail, setEmpEmail] = useState('')
  const [empPassword, setEmpPassword] = useState('')
  const [error, setError] = useState('')
  const [loading, setLoading] = useState(false)
  const navigate = useNavigate()

  async function sendData(e) {
    e.preventDefault()
    setError('')
    setLoading(true)

    try {
      const employee = {
        emp_id: Number(empId),
        emp_name: empName,
        designation: empDesignation,
        stack: empStack,
        emp_email: empEmail,
        emp_password: empPassword
      }
      const response = await fetch('http://localhost:8080/v1/user/addemp', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(employee)
      })
      const result = await response.text()
      if (!response.ok || result.toLowerCase().includes('error')) {
        throw new Error(result || 'Registration failed')
      }
      navigate('/login', { state: { registered: true } })
    } catch (err) {
      setError(err.message === 'Failed to fetch'
        ? 'Cannot connect to the backend. Start the Spring Boot application and try again.'
        : err.message)
    } finally {
      setLoading(false)
    }
  }

  return (
    <main className="auth-page registration-page">
      <section className="auth-card registration-card">
        <Link className="back-link" to="/">← Home</Link>
        <div className="brand-mark">HRMS</div>
        <p className="eyebrow">GET STARTED</p>
        <h1>Employee registration</h1>
        <p className="muted">Create an account using your employee details.</p>
        <form onSubmit={sendData} className="form-stack">
          <label htmlFor="emp-name">Full name</label>
          <input id="emp-name" type="text" placeholder="Enter your name" value={empName} onChange={e => setEmpName(e.target.value)} required />
          <label htmlFor="emp-id">Employee ID</label>
          <input id="emp-id" type="number" min="1" placeholder="Enter employee ID" value={empId} onChange={e => setEmpId(e.target.value)} required />
          <label htmlFor="emp-designation">Designation</label>
          <input id="emp-designation" type="text" placeholder="e.g. Software Engineer" value={empDesignation} onChange={e => setEmpDesignation(e.target.value)} required />
          <label htmlFor="emp-stack">Stack / Department</label>
          <input id="emp-stack" type="text" placeholder="e.g. Java FSD" value={empStack} onChange={e => setEmpStack(e.target.value)} required />
          <label htmlFor="emp-email">Email address</label>
          <input id="emp-email" type="email" autoComplete="username" placeholder="you@example.com" value={empEmail} onChange={e => setEmpEmail(e.target.value)} required />
          <label htmlFor="emp-password">Password</label>
          <input id="emp-password" type="password" autoComplete="new-password" placeholder="Create a password" value={empPassword} onChange={e => setEmpPassword(e.target.value)} required />
          {error && <p className="error-message" role="alert">{error}</p>}
          <button className="primary-button" type="submit" disabled={loading}>{loading ? 'Registering...' : 'Register'}</button>
        </form>
        <p className="auth-switch">Already registered? <Link to="/login">Login</Link></p>
      </section>
    </main>
  )
}

export default Registration
