-- Create Countries Table
CREATE TABLE countries (
    country_id INT PRIMARY KEY,
    country_name VARCHAR(100)
);

-- Create COVID Cases Table
CREATE TABLE covid_cases (
    case_id INT PRIMARY KEY,
    country_id INT,
    report_date DATE,
    confirmed_cases INT,
    FOREIGN KEY (country_id) REFERENCES countries(country_id)
);

-- Insert Data into Countries Table
INSERT INTO countries (country_id, country_name) VALUES
(1, 'India'),
(2, 'USA'),
(3, 'Brazil'),
(4, 'Russia'),
(5, 'France');

-- Insert Data into COVID Cases Table
INSERT INTO covid_cases (case_id, country_id, report_date, confirmed_cases) VALUES
(101, 1, '2021-06-01', 28574350),
(102, 2, '2021-06-01', 33251939),
(103, 3, '2021-06-01', 16624980),
(104, 4, '2021-06-01', 5031583),
(105, 5, '2021-06-01', 5719877),
(106, 1, '2021-06-02', 28694879),
(107, 2, '2021-06-02', 33287914);

-- Find the Country with Highest Confirmed Cases
SELECT
    c.country_name,
    cc.confirmed_cases,
    cc.report_date
FROM covid_cases cc
INNER JOIN countries c
ON cc.country_id = c.country_id
WHERE cc.report_date = '2021-06-01'
ORDER BY cc.confirmed_cases DESC
LIMIT 1;