select
    ifFull(
        (
            select
                distinct salary
            from
                Employee
            order by
                salary desc
            limit
                1 offset 1
        ),
        null
    ) as SecondHighestSalary;

-- 窗口函数实现该功能
select
    if(count(*) = 0, null, salary) as SecondHighestSalary
from
    (
        select
            salary,
            dense_rank() over(
                order by
                    salary desc
            ) as ranking
        from
            Employee
    ) as temp
where
    ranking = 2