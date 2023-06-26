/*
Write an SQL query to rearrange the Products table so that each row has 
(product_id, store, price). If a product is not available in a store, 
do not include a row with that product_id and store combination in the result table.
Return the result table in any order.

Products table
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| product_id  | int     |
| store1      | int     |
| store2      | int     |
| store3      | int     |
+-------------+---------+
product_id is the primary key for this table.
Each row in this table indicates the product's price in 3 different stores: store1, store2, and store3.
If the product is not available in a store, the price will be null in that store's column.
*/

-- Use UNION
SELECT product_id, "store1" AS store, store1 AS price
FROM Products
WHERE store1 IS NOT NULL
UNION
SELECT product_id, "store2" AS store, store2 AS price
FROM Products
WHERE store2 IS NOT NULL
UNION
SELECT product_id, "store3" AS store, store3 AS price
FROM Products
WHERE store3 IS NOT NULL

-- Faster solution:
-- 1. Use UNION ALL: 
-- UNION performs a DISTINCT on the result set, eliminating any duplicate rows.
-- UNION ALL does not remove duplicates, and it therefore faster than UNION.
-- 2. Simplify. UNION assumes its column names from the first query
SELECT product_id, "store1" AS store, store1 AS price
FROM Products
WHERE store1 IS NOT NULL
UNION ALL
SELECT product_id, "store2", store2
FROM Products
WHERE store2 IS NOT NULL
UNION ALL
SELECT product_id, "store3", store3
FROM Products
WHERE store3 IS NOT NULL


/*
Example 1:

Input: 
Products table:
+------------+--------+--------+--------+
| product_id | store1 | store2 | store3 |
+------------+--------+--------+--------+
| 0          | 95     | 100    | 105    |
| 1          | 70     | null   | 80     |
+------------+--------+--------+--------+
Output: 
+------------+--------+-------+
| product_id | store  | price |
+------------+--------+-------+
| 0          | store1 | 95    |
| 0          | store2 | 100   |
| 0          | store3 | 105   |
| 1          | store1 | 70    |
| 1          | store3 | 80    |
+------------+--------+-------+


*/