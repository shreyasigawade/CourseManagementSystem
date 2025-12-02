import { Link } from "react-router-dom";

function Home() {
  return (
    <div className="container text-center mt-5">
      <img
        src="/e-learning-logo-template.jpg"
        alt="Logo"
        style={{ width: "180px", marginBottom: "20px" }}
      />

      <h1>Welcome to Course Management System</h1>
      <p className="mt-3 fs-5 text-muted">
        Manage courses, instructors, and more!
      </p>

      <Link className="btn btn-primary mt-3" to="/course-list">
        Go to Course List
      </Link>

      <div className="mt-4">
        <Link className="btn btn-success me-2" to="/register">
          Register
        </Link>
        <Link className="btn btn-outline-dark" to="/login">
          Login
        </Link>
      </div>
    </div>
  );
}

export default Home;
