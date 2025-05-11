import {Link} from "react-router-dom";
import "../../styles/default.css"; // css import
import "../../styles/login.css"; // css import

const Login = () => {
    return (
        <div className="login-container">
            <div className="login-card">
                <div className="login-sections">
                    <section className="login-section email-login">
                        <h2 className="login-title">LOGIN 👋</h2>
                        <form className="login-form">
                            <input type="email" placeholder="이메일" className="login-input"/>
                            <input type="password" placeholder="비밀번호" className="login-input"/>
                            <button type="submit" className="login-button">로그인</button>
                        </form>
                    </section>

                    <section className="login-section social-signup">
                        <div className="divider">또는</div>

                        <a href="http://localhost:8080/oauth2/authorization/google" className="google-button">
                            <img src="https://developers.google.com/identity/images/g-logo.png" alt="Google"/>
                            Google 로그인
                        </a>

                        <p className="signup-text">계정이 없으신가요? <Link to="/signup">회원가입</Link></p>
                    </section>
                </div>
            </div>
        </div>
    );
};

export default Login;
