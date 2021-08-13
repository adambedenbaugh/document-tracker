**Document Tracking Connector**

The Document Tracking Connector is for debugging processes that needs to be deployed. This connector can be set 
anywhere within the document flow to view the document and easily find the document by use of tracked fields.

The connector and operation require no setup. A new connector and operation does need to be created. The recommended 
modification is to set the tracking fields. 

**How to Load Connector into Account:**



**Example Use Cases:**

* Applying document tracking anywhere in the process.  This is especially useful if all the operations are batch.  This connector could be put in line at some point where the documents are split, recording the record id's per document in process reporting and searching by tracked fields.
* Ability to retrieve documents anywhere in the process from the documents API.  This could be particularly useful for test harness processes and test assertion.
* Ability to record un-truncated error results or to process reporting or recording documents at specific steps for troubleshooting.  Notify and exception shapes would logically be used, but are truncated at 10K characters.  The return documents shape can accomplish this, but is not usable in webservice processes since this shape is functional.