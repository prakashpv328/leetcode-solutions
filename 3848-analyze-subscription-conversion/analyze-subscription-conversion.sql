select user_id,
    ROUND(AVG(IF(activity_type='free_trial', activity_duration, NULL)), 2) AS trial_avg_duration,
    ROUND(AVG(IF(activity_type='paid', activity_duration, NULL)), 2) AS paid_avg_duration
    from UserActivity
    group by user_id having
    COUNT(IF(activity_type = 'free_trial', 1, NULL)) > 0
    AND
    COUNT(IF(activity_type = 'paid', 1, NULL)) > 0;