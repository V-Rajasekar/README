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

Here payload is a text column in the Postgres database holding a JSON message which has an array of different parties. The challenge is to fetch the receiver ContactEmail from this parties array for party type='receiver'
Solution: use the ->> operator along with the json_array_elements function to fetch elements from the parties array. The json_array_elements function will expand the JSON array into multiple rows, and then you can use the ->> operator to access specific fields within each element.
Note: 
- Please ensure that the data column contains valid JSON data for this query to work correctly. If the data is not in valid JSON format, casting it to JSON will result in an error.
- we use the -> operator to access the parties object within the JSON data and then use the ->> operator to extract the contactEmail value as text
- working with JSON data in a TEXT column requires explicit type casting (::json) to use JSON functions and operators. It's generally recommended to use the jsonb data type if you frequently work with JSON data in PostgreSQL, as it provides more efficient storage and indexing for JSON data.

```sql
SELECT customer_no, created_timestamp, parties_obj->>'type' as partyType,
 parties_obj->>'contactEmail' as receiverEmail
FROM party_contact pel, 
 LATERAL JSON_ARRAY_ELEMENTS(payload::json->'parties') AS parties_obj
WHERE customer_no = '1234'
and parties_obj->>'type' = 'receiver'
```
