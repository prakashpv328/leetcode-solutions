# Write your MySQL query statement below
select id,
    max(if(month="Jan",revenue,null)) as Jan_revenue,
    max(if(month="Feb",revenue,null)) as Feb_revenue,
    max(if(month="Mar",revenue,null)) as Mar_revenue,
    max(if(month="Apr",revenue,null)) as Apr_revenue,
    max(if(month="May",revenue,null)) as May_revenue,
    max(if(month="Jun",revenue,null)) as Jun_revenue,
    max(if(month="Jul",revenue,null)) as Jul_revenue,
    max(if(month="Aug",revenue,null)) as Aug_revenue,
    max(if(month="Sep",revenue,null)) as Sep_revenue,
    max(if(month="Oct",revenue,null)) as Oct_revenue,
    max(if(month="Nov",revenue,null)) as Nov_revenue,
    max(if(month="Dec",revenue,null)) as Dec_revenue

from Department
Group by id
-- order by id