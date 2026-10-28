import React from 'react'
import { Link } from 'react-router-dom'

function Home() {
  return (
    <main className="auth-page">
      <section className="auth-card welcome-card">
        <div className="brand-mark">HRMS</div>
        <p className="eyebrow">HUMAN RESOURCE MANAGEMENT</p>
        <h1>Employee Portal</h1>
        <p className="muted">Sign in to view your attendance records, including daily in-time and out-time.</p>
        <div className="action-stack">
          <Link className="primary-link" to="/login">Login</Link>
          <Link className="secondary-link" to="/registration">Register as an employee</Link>
        </div>
      </section>
    </main>
  )
}

export default Home
