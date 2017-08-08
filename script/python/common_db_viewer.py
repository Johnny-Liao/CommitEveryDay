#!/usr/bin/env python
# -*- coding:utf-8 -*-
# Author : John.L

import records
import sys


doc="""
Usage : 
    python {filename} db_num table_name_pattern sql 
    sql : 'num_f=123 and str="xxx"'

Show information from specify table in db.

""".format(filename=__file__)


if len(sys.argv) < 2:
    print doc
    sys.exit()

db_num = sys.argv[1]
table_name_pattern = sys.argv[2]

sql='1=1'
if len(sys.argv) == 4:
    sql = sys.argv[3]

# Pre set db connection
urls={
# such like
0: 'mysql://user_name:passwd@host:port/db_name',
}


# Get db connection
url=urls.get(int(db_num))
if url == '':
    print 'Can\'t get url in {}'.format(urls)
    sys.exit(1)
print 'Database : {}'.format(url)

db = records.Database(url)

# Get all tables
tables = db.query('show tables')
table_name_list = [ v for in_dict in tables.as_dict() for k, v in in_dict.items() ]
print 'All tables : {}'.format(table_name_list)

# Get selected table
table_name=''
table_name=[ x for x in table_name_list if table_name_pattern in x ][0]
if table_name == '':
    print 'Can\'t get {} in {}'.format(table_name_pattern, table_name_list)
    sys.exit(1)
print 'Selected Table : {}'.format(table_name)
print '\n\n'



# Show information what u wanted
def showTableInfo(table, sql='1=1'):
    sql = 'select * from {} where {}'.format(table, sql)
    rows = db.query(sql)
    print "exec : {}".format(sql)
    print rows.dataset


showTableInfo(table_name, sql)
