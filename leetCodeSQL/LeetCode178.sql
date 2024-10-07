-- 查询分数表中的排名情况，如果成绩相同，应该使用相同排名，使用并列连续排名的开窗函数解决该问题
-- 组合查询语句
select
    score,
    rank
from
    (
        select
            id,
            score,
            dense_rank() over(
                order by
                    score desc
            ) as rank
        from
            Scores
    ) as temp 
    
-- 如果在MySQL5.0之前没有开窗函数的时候，使用别的办法模拟开窗函数实现此功能
-- 查一下大于等于这个分数的有多少人，就知道这个分数的排名是多少了
select
    s1.score,
    (
        select
            count(distinct s2.score)
        from
            Scores
        where
            s2.score >= s1.score
    ) as 'rank'
from
    Scores
order by
    s1.score desc;