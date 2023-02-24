CREATE TABLE visits_revenue
(
    id          INTEGER IDENTITY PRIMARY KEY,
    visit_date  DATE,
    cost        INTEGER NOT NULL
);