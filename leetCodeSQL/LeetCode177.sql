-- 使用函数来实现动态传入的功能，查询工资表中第N高的工资，如果没有，返回null
create function getNHighestSalary(n int)
begin
    return int
    (
        select if(count(*)=0,null,salary) from
        (
            select distinct salary,rank() over(order by salary desc) as newIndex from Employee
        )
    where newIndex=n
    );
end


