import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import Login from "./pages/auth/Login";
import Signup from "./pages/auth/Signup";
import OAuth2RedirectHandler from "./pages/auth/OAuth2RedirectHandler";
import Main from "./pages/main/Main";
import NotFound from "./pages/error/NotFound";
import "./styles/login.css";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Navigate to="/login" />} />
                <Route path="/login" element={<Login />} />
                <Route path="/signup" element={<Signup />} />
                <Route path="/oauth2/success" element={<OAuth2RedirectHandler />} />
                <Route path="/main" element={<Main />} />
                <Route path="*" element={<NotFound />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;
