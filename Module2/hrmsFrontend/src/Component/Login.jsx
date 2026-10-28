import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

function Login() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [error, setError] = useState('')
  const [loading, setLoading] = useState(false)
  const navigate = useNavigate()

  async function handleLogin(e) {
    e.preventDefault()
    setError('')
    setLoading(true)

    try {
      const response = await fetch('http://localhost:8080/v1/user/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ emp_email: email, emp_password: password })
      })
      const data = await response.json()
      if (!response.ok) {
        throw new Error(data.message || 'Login failed')
      }
      localStorage.setItem('hrmsEmployee', JSON.stringify(data))
      navigate('/dashboard')
    } catch (err) {
      setError(err.message === 'Failed to fetch'
        ? 'Cannot connect to the backend. Start the Spring Boot application and try again.'
        : err.message)
    } finally {
      setLoading(false)
    }
  }

  return (
    <main className="auth-page">
      <section className="auth-card">
        <Link className="back-link" to="/">← Home</Link>
        <div className="brand-mark">HRMS</div>
        <p className="eyebrow">EMPLOYEE ACCESS</p>
        <h1>Welcome back</h1>
        <p className="muted">Login to continue to your attendance dashboard.</p>
        <form onSubmit={handleLogin} className="form-stack">
          <label htmlFor="login-email">Email address</label>
          <input id="login-email" type="email" autoComplete="username" placeholder="you@example.com" value={email} onChange={e => setEmail(e.target.value)} required />
          <label htmlFor="login-password">Password</label>
          <input id="login-password" type="password" autoComplete="current-password" placeholder="Enter your password" value={password} onChange={e => setPassword(e.target.value)} required />
          {error && <p className="error-message" role="alert">{error}</p>}
          <button className="primary-button" type="submit" disabled={loading}>{loading ? 'Signing in...' : 'Login'}</button>
        </form>
        <p className="auth-switch">New employee? <Link to="/registration">Create an account</Link></p>
      </section>
    </main>
  )
}

export default Login
