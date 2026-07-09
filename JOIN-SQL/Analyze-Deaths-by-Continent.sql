-- Create Continents Table
CREATE TABLE continents (
    continent_id INT PRIMARY KEY,
    continent_name VARCHAR(50)
);

-- Create COVID Cases Table
CREATE TABLE covid_cases (
    case_id INT PRIMARY KEY,
    country_name VARCHAR(100),
    continent_id INT,
    total_deaths INT,
    FOREIGN KEY (continent_id) REFERENCES continents(continent_id)
);

-- Insert Data into Continents Table
INSERT INTO continents (continent_id, continent_name) VALUES
(1, 'Asia'),
(2, 'North America'),
(3, 'South America'),
(4, 'Europe'),
(5, 'Africa');

-- Insert Data into COVID Cases Table
INSERT INTO covid_cases (case_id, country_name, continent_id, total_deaths) VALUES
(101, 'India', 1, 531915),
(102, 'China', 1, 5236),
(103, 'USA', 2, 1123836),
(104, 'Canada', 2, 53123),
(105, 'Brazil', 3, 703291),
(106, 'Argentina', 3, 130472),
(107, 'France', 4, 167985),
(108, 'Russia', 4, 402756),
(109, 'South Africa', 5, 102595),
(110, 'Nigeria', 5, 3155);

-- INNER JOIN with GROUP BY
SELECT
    c.continent_name,
    SUM(cc.total_deaths) AS total_deaths
FROM covid_cases cc
INNER JOIN continents c
ON cc.continent_id = c.continent_id
GROUP BY c.continent_name
ORDER BY total_deaths DESC;