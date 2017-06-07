#!/usr/bin/env python
# -*- coding:utf-8 -*-
import records
import sys


doc="""
Usage : showTable.py [tableName/all]

    Show special/all table infornation. 

eg:
58_cloud_search_admin
58_cloud_search_app
58_cloud_search_appconfig
58_cloud_search_appstate
58_cloud_search_field
58_cloud_search_machine_merger_allocat
58_cloud_search_machine_resource
58_cloud_search_machine_searcher_allocat
58_cloud_search_report_statistic
58_cloud_search_resource_distribution
58_cloud_search_resource_wmb
58_cloud_search_resource_wtable
58_cloud_search_userapp
"""

table_name = ""
if len(sys.argv) == 2:
    table_name = sys.argv[1]
else:
    print doc
    sys.exit()

db = records.Database('mysql://user:passwd@hostname:port/dbname')

def showTable(table):
    sql = 'select * from {}'.format(table)
    rows = db.query(sql)
    print "Table =============== {}".format(table)
    for r in rows.as_dict():
        print r

def showAllTable():
    # show all table information
    tableList = []
    tables = db.query('show tables')
    print "Tables : "
    for r in tables:
        print r.Tables_in_db58_wcs
        tableList.append(r.Tables_in_db58_wcs)

    print tableList

    for table in tableList:
        showTable(table)

if table_name != "all":
    showTable(table_name)
else:
    showAllTable()
