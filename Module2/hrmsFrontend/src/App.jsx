import './App.css'
import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom'
import Home from './Component/Home'
import Login from './Component/Login'
import Registration from './Component/Registration'
import Dashboard from './Component/Dashboard'

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/registration" element={<Registration />} />
        <Route path="/dashboard" element={localStorage.getItem('hrmsEmployee') ? <Dashboard /> : <Navigate to="/login" replace />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
