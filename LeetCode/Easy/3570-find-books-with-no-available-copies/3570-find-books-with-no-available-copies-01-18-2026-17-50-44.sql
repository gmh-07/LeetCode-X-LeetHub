# Write your MySQL query statement below
SELECT 
    l.book_id,
    l.title,
    l.author,
    l.genre,
    l.publication_year,
    COUNT(b.record_id) AS current_borrowers
FROM library_books l
JOIN borrowing_records b
ON l.book_id = b.book_id
WHERE b.return_date IS NULL
GROUP BY 
    l.book_id,
    l.title,
    l.author,
    l.genre,
    l.publication_year,
    l.total_copies
HAVING COUNT(b.record_id) = l.total_copies
ORDER BY current_borrowers DESC,l.title;










-- 🚫 The core mistake
-- COUNT(b.record_id)


-- is an aggregate function, and aggregates cannot be used in WHERE.

-- 🧠 Analogy (easy to remember)

-- Think of SQL execution like sorting exam papers:

-- FROM → collect all papers

-- WHERE → remove invalid papers before counting

-- GROUP BY → group papers by student

-- COUNT() → count marks after grouping

-- HAVING → filter based on the count

-- SELECT → show results

-- ORDER BY → arrange output

-- You tried to say:

-- “Reject students whose final score is low”
-- before the score was even calculated

-- That’s why SQL refuses.

-- 🔑 Correct rule (memorize this)

-- WHERE filters rows
-- HAVING filters groups

-- If you see COUNT, SUM, AVG, MIN, MAX → it belongs in HAVING.

-- -- SELECT 
-- --     l.book_id,
-- --     l.title,
-- --     l.author,
-- --     l.genre,
-- --     l.publication_year,
-- --     COUNT(b.record_id) AS current_borrowers
-- -- FROM library_books l
-- -- JOIN borrowing_records b
-- -- ON l.book_id = b.book_id
-- -- WHERE b.return_date IS NULL AND CoUNT(b.record_id) = l.total_copies
-- -- ORDER BY current_borrowers DESC,l.title;
