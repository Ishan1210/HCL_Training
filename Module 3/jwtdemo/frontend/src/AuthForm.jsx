import React from 'react'
import api from './api'
import SubmitButton from './SubmitButton'
import { useState, useActionState } from 'react'

const AuthForm = () => {
    const [node, setNode] = useState("login");
    const submitAction = async (prevState, formData)=>{
        
    }
  return (
    <div>AuthForm</div>
  )
}

export default AuthForm