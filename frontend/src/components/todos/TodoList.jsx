import React from 'react'

function TodoList({ todoList, setHover, deleteItem, editItem, toggleCheck }) {
    const onMouseEnter = (item) => {
        setHover(item.id, true)
    }

    const onMouseOut = (item) => {
        setHover(item.id, false)
    }

    return (
        <>
            {todoList.map((item) => (
                <div
                    className="TodoElement"
                    key={item.id}
                    onMouseEnter={() => onMouseEnter(item)}
                    onMouseLeave={() => onMouseOut(item)}
                >
                    <input
                        type="checkbox"
                        checked={item.checked}
                        onChange={() => toggleCheck(item.id)}
                    />
                    {item.checked ? <del>{item.title}</del> : item.title}{' '}
                    {item.hover && (
                        <>
                            <button
                                style={{ marginLeft: '1rem' }}
                                onClick={() => deleteItem(item.id)}
                            >
                                X
                            </button>
                            <button
                                style={{ marginLeft: '1rem' }}
                                onClick={() => editItem(item.id)}
                            >
                                ✎
                            </button>
                        </>
                    )}
                </div>
            ))}
        </>
    )
}

export default TodoList
