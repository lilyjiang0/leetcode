/* 
Write an SQL query to find the ids of products that 
are both low fat and recyclable.
Return the result table in any order.


+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| product_id  | int     |
| low_fats    | enum    |
| recyclable  | enum    |
+-------------+---------+
product_id is the primary key for this table.
low_fats is an ENUM of type ('Y', 'N') where 'Y' means this product is low fat and 'N' means it is not.
recyclable is an ENUM of types ('Y', 'N') where 'Y' means this product is recyclable and 'N' means it is not.
*/

-- Use =
SELECT product_id 
FROM Products 
WHERE low_fats = "Y" AND recyclable = "Y"

-- Use in
SELECT product_id
FROM Products
WHERE
low_fats in ('Y') AND recyclable in ('Y');

-- Use like
SELECT product_id
FROM Products
WHERE
low_fats like 'Y%' AND recyclable like 'Y%';


/*
Example 1:

Input: 
Products table:
+-------------+----------+------------+
| product_id  | low_fats | recyclable |
+-------------+----------+------------+
| 0           | Y        | N          |
| 1           | Y        | Y          |
| 2           | N        | Y          |
| 3           | Y        | Y          |
| 4           | N        | N          |
+-------------+----------+------------+
Output: 
+-------------+
| product_id  |
+-------------+
| 1           |
| 3           |
+-------------+

*/