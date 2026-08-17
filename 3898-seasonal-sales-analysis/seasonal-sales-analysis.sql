# Write your MySQL query statement below
With
season_sales as (
    select 
        case
            when Month(s.sale_date) in (12,1,2) then 'Winter'
            when Month(s.sale_date) in (3,4,5) then 'Spring'
            when Month(s.sale_date) in (6,7,8) then 'Summer'
            when Month(s.sale_date) in (9,10,11) then 'Fall'
        end as season,
        p.category,
        sum(s.quantity) as total_quantity,
        sum(s.quantity*s.price) as total_revenue
    from sales s
    join products p on s.product_id=p.product_id
    group by season,p.category
 ),
 rank_category as (
    select
        season,
        category,
        total_quantity,
        total_revenue,
        ROW_NUMBER() over(partition by season order by total_quantity desc,total_revenue desc) as rnk
    from season_sales
 )

 select
    season,
    category,
    total_quantity,
    total_revenue
from rank_category
where rnk=1
order by season