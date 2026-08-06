# Write your MySQL query statement below
select person_name
from (
    select *,SUM(weight) over (order by turn) as total from Queue
) as sub where total <= 1000
order by turn desc 
limit 1;