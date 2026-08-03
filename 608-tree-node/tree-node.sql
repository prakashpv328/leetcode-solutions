# Write your MySQL query statement below
with cte as(
    select p_id from Tree where p_id is not null
)

select id,
    case 
        when p_id is null then "Root"
        when id not in (select p_id from cte) then "Leaf"
        else "Inner"
    end as type
from Tree;

