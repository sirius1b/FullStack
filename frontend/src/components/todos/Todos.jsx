import React, { useEffect, useState } from 'react'
import TodoInput from './TodoInput'
import TodoList from './TodoList'

function Todos() {
    const initState = [
        {
            id: 0,
            title: 'Initial Task',
            hover: false,
            checked: false,
        },
    ]
    const [todoList, setTodoList] = useState(initState)

    const editInitState = { edit: false, id: '0' }
    const [edit, setEdit] = useState(editInitState)

    const addTodo = (todo) => {
        setTodoList([...todoList, todo])
    }

    const setHover = (itemId, hover) => {
        console.log(itemId + ' ' + hover)

        const itemIndex = todoList.findIndex((todo) => itemId === todo.id)

        const updatedItems = [...todoList]

        updatedItems.forEach((e) => {
            e.hover = false
        })

        updatedItems[itemIndex] = {
            ...updatedItems[itemIndex],
            hover: hover,
        }

        setTodoList(updatedItems)
    }

    const deleteItem = (deleteId) => {
        const updatedList = todoList.filter((item) => item.id != deleteId)

        if (edit.id == deleteId && edit.edit) {
            setEdit(editInitState)
        }

        setTodoList(updatedList)
    }

    const editSave = (id, text) => {
        const itemIndex = todoList.findIndex((todo) => todo.id === id)

        const updatedItems = [...todoList]

        updatedItems[itemIndex] = {
            ...updatedItems[itemIndex],
            title: text,
        }

        setTodoList(updatedItems)
        setEdit({ id: '0', edit: false })
    }

    const editItem = (id) => {
        setEdit({ id: id, edit: true })
    }

    const toggleCheck = (id) => {
        const itemIndex = todoList.findIndex((todo) => todo.id === id)

        const updatedItems = [...todoList]

        updatedItems[itemIndex] = {
            ...updatedItems[itemIndex],
            checked: !updatedItems[itemIndex].checked,
        }

        setTodoList(updatedItems)
    }

    return (
        <>
            <div className="MainContainer">
                <TodoInput
                    todoList={todoList}
                    addTodo={addTodo}
                    editState={edit}
                    editSave={editSave}
                />
                <TodoList
                    todoList={todoList}
                    setHover={setHover}
                    deleteItem={deleteItem}
                    editItem={editItem}
                    toggleCheck={toggleCheck}
                />
            </div>
        </>
    )
}

export default Todos
