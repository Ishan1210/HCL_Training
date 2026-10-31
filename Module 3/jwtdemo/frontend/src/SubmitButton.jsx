import React from 'react';
import { useFormStatus } from 'react-dom';

const SubmitButton = () => {
  const { pending } = useFormStatus();

  return (
    <button
      type="submit"
      disabled={pending}
      className="w-full rounded-xl bg-gradient-to-r from-indigo-600 to-purple-600 px-6 py-3 text-sm font-semibold text-white shadow-lg shadow-indigo-200 transition-all duration-300 hover:-translate-y-0.5 hover:from-indigo-700 hover:to-purple-700 hover:shadow-xl active:translate-y-0 disabled:cursor-not-allowed disabled:opacity-60 disabled:hover:translate-y-0"
    >
      {pending ? (
        <span className="flex items-center justify-center gap-2">
          <svg
            className="h-5 w-5 animate-spin"
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
          >
            <circle
              className="opacity-25"
              cx="12"
              cy="12"
              r="10"
              stroke="currentColor"
              strokeWidth="4"
            />
            <path
              className="opacity-75"
              fill="currentColor"
              d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4z"
            />
          </svg>
          Submitting...
        </span>
      ) : (
        <span className="flex items-center justify-center gap-2">
          Submit
          <span aria-hidden="true">→</span>
        </span>
      )}
    </button>
  );
};

export default SubmitButton;