import { useState, useEffect } from "react";

function TaskList() {
    const [tasks, setTasks] = useState([]);
    const [title, setTitle] = useState("");

    const fetchTasks = async () => {
        const res = await fetch("http://localhost:8080/api/tasks");
        const data = await res.json();
        setTasks(data);
    };

    const addTask = async () => {
        if (!title) return;
        await fetch("http://localhost:5173/api/tasks", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ title }),
        });
        setTitle("");
        fetchTasks();
    };

    const completeTask = async (id) => {
        await fetch(`http://localhost:5173/api/tasks/${id}/complete`, {
            method: "PUT",
        });
        fetchTasks();
    };

    useEffect(() => {
        fetchTasks();
    }, []);

    return (
        <div>
            <h2>Task Manager</h2>
            <input
                value={title}
                onChange={(e) => setTitle(e.target.value)}
                placeholder="Enter task"
            />
            <button onClick={addTask}>Add </button>
            <ul>
                {tasks.map((task) => (
                    <li key={task.id}>
                        {task.title} - {task.completed ? "✅" : "❌"}
                        {!task.completed && (
                            <button onClick={() => completeTask(task.id)}>Complete</button>
                        )}
                    </li>
                ))}
            </ul>
        </div>
    );
}
export default TaskList;