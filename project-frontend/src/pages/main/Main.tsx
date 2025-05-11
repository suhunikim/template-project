import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Main = () => {
    const navigate = useNavigate();
    const [user, setUser] = useState<any>(null);

    useEffect(() => {
        const token = localStorage.getItem("token");
        if (!token) {
            // ✅ 토큰 없으면 로그인 페이지로 이동
            navigate("/login");
            return;
        }

        axios.get("/api/user/me", {
            headers: {
                Authorization: `Bearer ${token}`
            }
        }).then(res => {
            setUser(res.data.data);
        }).catch(err => {
            // ✅ 토큰이 만료되었거나 인증 실패하면 로그인으로
            console.error(err);
            localStorage.removeItem("token");
            navigate("/login");
        });
    }, [navigate]);

    return (
        <div>
            <h1>메인 페이지</h1>
            {user && <p>{user.userName}님 환영합니다!</p>}
        </div>
    );
};

export default Main;
