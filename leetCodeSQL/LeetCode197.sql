-- 编写解决方案，找出与之前（昨天的）日期相比温度更高的所有日期的 id 。
select
    w1.id
from
    Weather w1,
    Weather w2
where
    datediff(w1.recordDate, w2.recordDate) = 1
    and w1.Temperature > w2.Temperature;