import React, { useEffect, useState } from 'react'

function TodoInput({ todoList, addTodo, editState, editSave }) {
    const [input, setInput] = useState('')

    const handleSubmit = (e) => {
        e.preventDefault()

        if (editState.edit) {
            editSave(editState.id, input)
        } else {
            addTodo({
                id: crypto.randomUUID(),
                title: input,
                hover: false,
                checked: false,
            })
        }

        setInput('')
    }

    useEffect(() => {
        console.log(editState)
        if (editState.edit) {
            const text = todoList.find((e) => e.id == editState.id)
            // console.log(text.title)
            setInput(text.title)
        } else {
            setInput('')
        }
    }, [editState])

    return (
        <div>
            <form>
                <label> Add Todos Here !! </label>
                <br />
                <input
                    type="text"
                    value={input}
                    onChange={(e) => setInput(e.target.value)}
                />
                <button type="submit" onClick={handleSubmit}>
                    {editState.edit ? 'Save It!' : 'Add New!'}
                </button>
            </form>
        </div>
    )
}

export default TodoInput
