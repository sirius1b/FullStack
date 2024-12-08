import React from 'react'
import { useEffect, useState } from 'react'

function Timer() {
    const [count, setCount] = useState(0)
    const [status, setStatus] = useState(false)

    useEffect(() => {
        if (status) {
            alert('Timer started')
            console.log(`status changed: ${status}`)
            const id = setInterval(() => {
                console.log('setting interval')
                console.log(count)
                setCount((count) => count + 1)
            }, 1000)

            return () => {
                console.log('clear')
                console.log(`clear: ${id}`)
                clearInterval(id)
            }
        } else {
            alert('Timer stopped!')
        }
    }, [status])

    return (
        <>
            <h2> Timer: </h2> <h3>{count}</h3>
            <button
                onClick={() => {
                    setStatus(true)
                }}
            >
                start
            </button>
            <button
                onClick={() => {
                    setStatus(false)
                }}
            >
                Stop
            </button>
        </>
    )
}

export default Timer
