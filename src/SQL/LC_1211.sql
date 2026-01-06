/*Table: Queries
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| query_name  | varchar |
| result      | varchar |
| position    | int     |
| rating      | int     |
+-------------+---------+
This table may have duplicate rows.
This table contains information collected from some queries on a database.
The position column has a value from 1 to 500.
The rating column has a value from 1 to 5. Query with rating less than 3 is a poor query.
We define query quality as:
    The average of the ratio between query rating and its position.
We also define poor query percentage as:
    The percentage of all queries with rating less than 3.
Write a solution to find each query_name, the quality and poor_query_percentage.
Both quality and poor_query_percentage should be rounded to 2 decimal places.*/

SELECT query_name,
    ROUND(AVG(rating / position), 2) AS quality,
    ROUND((SUM(CASE WHEN rating<3 THEN 1 ELSE 0 END) / count(*)) * 100, 2) AS poor_query_percentage
FROM Queries
GROUP BY query_name