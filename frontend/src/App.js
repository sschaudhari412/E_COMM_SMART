import { useEffect, useState } from "react";
import axios from "axios";

function App() {
  const [msg, setMsg] = useState("");

  useEffect(() => {
    axios.get("http://localhost:8080/api/hello")
      .then(res => setMsg(res.data))
      .catch(err => console.log(err));
  }, []);

  return (
    <div className="flex h-screen items-center justify-center text-2xl font-bold">
      {msg || "Loading..."}
    </div>
  );
}

export default App;
