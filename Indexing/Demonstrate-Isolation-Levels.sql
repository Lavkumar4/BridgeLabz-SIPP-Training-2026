-- 1. Database & Table Setup

CREATE TABLE IF NOT EXISTS isolation_demo (
    id INT PRIMARY KEY,
    country VARCHAR(50) NOT NULL,
    confirmed INT NOT NULL
);

-- Reset table data to clean state
TRUNCATE TABLE isolation_demo;

INSERT INTO isolation_demo (id, country, confirmed) VALUES 
(1, 'India', 500),
(2, 'USA', 800);


-- 2. Scenario 1: Dirty Read (READ UNCOMMITTED) vs Fix (READ COMMITTED)


-- SESSION A (Terminal 1)
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
START TRANSACTION;
SELECT * FROM isolation_demo WHERE id = 1; 
-- [Observe]: Reads uncommitted changes made by Session B if executed during B's transaction.
COMMIT;

-- SESSION B (Terminal 2 - Simulating concurrent update and rollback)
START TRANSACTION;
UPDATE isolation_demo SET confirmed = 9999 WHERE id = 1;
-- (Session A reads 9999 here - DIRTY READ)
ROLLBACK; -- Values revert back to 500

-- FIX FOR DIRTY READ:
-- Run in Session A:
SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
START TRANSACTION;
SELECT * FROM isolation_demo WHERE id = 1; -- Safely reads 500 (ignores uncommitted 9999)
COMMIT;



-- 3. Scenario 2: Non-Repeatable Read (READ COMMITTED) vs Fix (REPEATABLE READ)
-- SESSION A (Terminal 1)
SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
START TRANSACTION;
SELECT confirmed FROM isolation_demo WHERE id = 1; -- First read: Returns 500

-- SESSION B (Terminal 2 - Updating same row)
START TRANSACTION;
UPDATE isolation_demo SET confirmed = 1200 WHERE id = 1;
COMMIT;

-- SESSION A (Terminal 1 - Second Read)
SELECT confirmed FROM isolation_demo WHERE id = 1; -- Returns 1200 (NON-REPEATABLE READ)
COMMIT;

-- FIX FOR NON-REPEATABLE READ:
-- Run in Session A:
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
START TRANSACTION;
SELECT confirmed FROM isolation_demo WHERE id = 1; -- First read: Returns 1200
-- (Session B updates id = 1 to 2000 and COMMITS)
SELECT confirmed FROM isolation_demo WHERE id = 1; -- Second read: Still returns 1200 (Snapshot Read)
COMMIT;



-- 4. Scenario 3: Phantom Read (READ COMMITTED) vs Fix (SERIALIZABLE)


-- SESSION A (Terminal 1)
SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
START TRANSACTION;
SELECT * FROM isolation_demo WHERE confirmed > 400; -- Returns 2 rows (India, USA)

-- SESSION B (Terminal 2 - Inserting new row matching range)
START TRANSACTION;
INSERT INTO isolation_demo VALUES (3, 'Japan', 600);
COMMIT;

-- SESSION A (Terminal 1 - Second Read)
SELECT * FROM isolation_demo WHERE confirmed > 400; -- Returns 3 rows (PHANTOM READ: Japan added)
COMMIT;

-- FIX FOR PHANTOM READ (SERIALIZABLE Strict Concurrency Control):
-- Run in Session A:
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
START TRANSACTION;
SELECT * FROM isolation_demo WHERE confirmed > 400; 

-- (If Session B tries: INSERT INTO isolation_demo VALUES (4, 'Germany', 700);
-- Session B gets BLOCKED until Session A issues COMMIT)

COMMIT; -- Unblocks Session B