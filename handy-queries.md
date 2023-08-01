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
## Query to filter and fetch an element from a Json Array object. 
Here payload is a text column in the Postgres database holding a JSON message which has an array of different parties. The challenge is to fetch the consigneeContactEmail from this parties array for party type='Consignee'
Solution: using json_array_elements 
```sql
SELECT consignment_no, created_timestamp, parties_obj->>'type' as partyType, parties_obj->>'contactEmail' as consigneeEmail  FROM logs.ph_edi_logs pel, 
 LATERAL json_array_elements(payload::json->'parties') AS parties_obj WHERE consignment_no = '1234'
and parties_obj->>'type' = 'Consignee'
```
