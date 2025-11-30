function Home() {
  return (
    <div className="container text-center mt-5">
      <img
        src="/e-learning-logo-template.jpg" // <-- this works with public folder
        alt="Logo"
        style={{ width: "180px", marginBottom: "20px" }}
      />
      <h1>Welcome to Course Management System</h1>
      <p className="mt-3 fs-5 text-muted">
        Manage courses, instructors, and more!
      </p>
      <a className="btn btn-primary mt-3" href="/course-list">
        Go to Course List
      </a>
    </div>
  );
}

export default Home;
