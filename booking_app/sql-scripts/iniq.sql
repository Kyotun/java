CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    email text UNIQUE NOT NULL,
    password text NOT NULL,
    name text,
    surname text,
    birthday date,
    bio text,
    highest_level_of_education text,
    topics text[]
);

CREATE TABLE IF NOT EXISTS public.courses (
    id SERIAL PRIMARY KEY,
    teacherID int NOT NULL,
    course_date date NOT NULL,
    initial_capacity int NOT NULL,
    available_capacity int NOT NULL,
    price double precision,
    cancel_policy text,
    receipt text,
    FOREIGN KEY (teacherID) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS public.bookings (
    id SERIAL PRIMARY KEY,
    courseID int,
    studentID int,
    date_of_booking date,
    cancel_policy text,
    FOREIGN KEY (courseID) REFERENCES courses(id),
    FOREIGN KEY (studentID) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS public.reviews (
    id SERIAL PRIMARY KEY,
    userID int,
    rating int,
    review_text text,
    FOREIGN KEY (userID) REFERENCES users(id)
);

