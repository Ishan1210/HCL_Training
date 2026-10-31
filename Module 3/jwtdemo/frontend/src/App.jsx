import React from 'react'

const App = () => {
  return (
    <div className="min-h-screen flex items-center justify-center bg-gradient-to-br from-pink-500 via-purple-600 to-blue-600 px-4">

      <div className="relative w-full max-w-xl overflow-hidden rounded-3xl border border-white/30 bg-white/20 p-10 text-center shadow-2xl backdrop-blur-xl">

        {/* Decorative circles */}
        <div className="absolute -right-16 -top-16 h-48 w-48 rounded-full bg-yellow-300/40 blur-3xl"></div>
        <div className="absolute -bottom-16 -left-16 h-48 w-48 rounded-full bg-pink-400/40 blur-3xl"></div>

        <div className="relative z-10">

          {/* Icon */}
          <div className="mx-auto mb-7 flex h-24 w-24 items-center justify-center rounded-3xl bg-gradient-to-br from-yellow-300 via-orange-400 to-pink-500 shadow-xl shadow-pink-900/30">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              strokeWidth={1.8}
              stroke="white"
              className="h-12 w-12"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                d="M12 3L5 6v5c0 5 3 8 7 10 4-2 7-5 7-10V6l-7-3z"
              />
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                d="M9 12l2 2 4-4"
              />
            </svg>
          </div>

          {/* Heading */}
          <p className="mb-3 text-sm font-bold uppercase tracking-[0.3em] text-yellow-200">
            Authentication System
          </p>

          <h1 className="mb-5 text-4xl font-black tracking-tight text-white sm:text-5xl">
            Welcome to the
            <span className="mt-2 block bg-gradient-to-r from-yellow-200 via-pink-200 to-cyan-200 bg-clip-text text-transparent">
              JWT Demo
            </span>
          </h1>

          <p className="mx-auto mb-8 max-w-md text-base leading-relaxed text-white/90">
            Experience secure and seamless authentication
            powered by JSON Web Tokens.
          </p>

          {/* Button */}
          <button className="rounded-full bg-gradient-to-r from-yellow-300 via-orange-400 to-pink-500 px-9 py-3.5 font-bold text-white shadow-lg shadow-pink-900/30 transition duration-300 hover:-translate-y-1 hover:scale-105 hover:shadow-xl">
            Get Started →
          </button>

          {/* Status */}
          <div className="mt-8 inline-flex items-center gap-2 rounded-full border border-white/30 bg-white/20 px-5 py-2 text-sm font-semibold text-white">
            <span className="h-2.5 w-2.5 animate-pulse rounded-full bg-lime-300"></span>
            Demo Ready
          </div>

          <div className="mt-10 border-t border-white/20 pt-6 text-sm font-medium text-white/80">
            ✨ Powered by React & Tailwind CSS
          </div>

        </div>
      </div>
    </div>
  )
}

export default App