#Handy queries

## Query to find the long running sql 

```sql
select pid, state, usename, query, query_start, now()-query_start as age
from pg_stat_activity
where pid in (
select pid from pg_locks l
join pg_class t on l.relation = t.oid
and t.relkind = 'r'
--where t.relname = 'ph_maintenance_table_cleanup_log'
) order by query_start;

Query to kill
SELECT pg_terminate_backend(6013);
```
