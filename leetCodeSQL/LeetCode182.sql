-- 查找重复的邮箱
-- 转变思路，查找出现两次及以上的邮箱
select
    email,
    count(email) as total_count
from
    Person
group by
    email;

select
    email
from
    (
        select
            email,
            count(email) as total_count
        from
            Person
        group by
            email
    ) as temp
where
    temp.total_count >= 2;