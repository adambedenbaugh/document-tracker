# Document Tracker Connector

## Purpose

The Document Tracker Connector is for debugging processes that needs to be deployed for testing. This connector can be 
placed anywhere within the document flow to view the document and easily find the document by use of tracked fields. Modifying a process for debugging can occur easily by placing the connector within the document flow.

The connection requires no setup. The operation also requires no set up, but tracked fields are encouraged. A 
new 
connector and operation will need to be created. Multiple operations should be created for each insertion point 
to view document location within the document flow. 

## Getting Started

Installation of a custom connector for Dell Boomi is relatively simple, but it will require Developer privileges to 
upload 
and release the connector files.

### Download the latest release

Download the latest Document Tracker Connector release from the [Releases](https://github.com/adambedenbaugh/document-tracker/releases) page.

You should now have a zip file that contains the following files:

* document-tracker-connector-\<version>--car.zip
* connector-descriptor.xml

### Create a Boomi Connector Group
Add a custom connector group to your Boomi account by following the instructions described in the Boomi documentation located here: https://help.boomi.com/bundle/connectors/page/t-atm-Adding_a_connector_group.html

### Upload the connector
Using the files that you extracted from the release download, upload the connector to the new connector group by following the instructions described in the Boomi documentation located here: https://help.boomi.com/bundle/connectors/page/t-atm-Adding_a_version_to_a_connector_group.html

### Upgrading the connector version
You can upgrade your Document Tracker Connector version by clicking the "Add Version" button in your existing 
Document Tracker Connector connector group.

### How to Use the Connector within Boomi

First start by building out the desired process. Once the process is complete, place the Document Tracker connector anywhere except for the start shape. The incoming document will be visible within Process Reporting. The 
connector does not modify the data. The operation should have document tracking setup. This configuration will allow 
for the documents passing through the connector to be easily found within Process Reporting.

A connection must be created but there is no configuration needed.

![Document Tracker Connection](resources/DocumentTrackerConnection.png?raw=true)

There is only one configuration within the operation, which is under the Tracking tab. The field should be
populated
with the document id. If you have multiple insertion points within the process, then multiple operations should be
created with unique names to aid in identifying which part of the process the documents originated from.

![Document Tracker Operation](resources/DocumentTrackerOperation.png?raw=true)
![Document Tracker Operation Tracking](resources/DocumentTrackerOperationTracking.png?raw=true)

The below images show a demo Document Tracker Connector process and how it looks like in Process Reporting. Within 
the process the Data 
Process shape
creates 6 documents. The output of the document is the number of the loop. The ID within Process Reporting is from the 
data
within the document (a single element flat file profile).

![Document Tracker Process Overview](resources/DocumentTrackerProcessOverview.png?raw=true)
![Document Tracker in Process Reporting](resources/DocumentTrackerProcessReporting.png?raw=true)




## Example Use Cases:

* Applying document tracking anywhere in the process.  This is especially useful if all the operations are batch.  This connector could be put in line at some point where the documents are split, recording the record id's per document in process reporting and searching by tracked fields.
* Ability to retrieve documents anywhere in the process from the documents API.  This could be particularly useful for test harness processes and test assertion.
* Ability to record un-truncated error results or to process reporting or recording documents at specific steps for troubleshooting.  Notify and exception shapes would logically be used, but are truncated at 10K characters.  The return documents shape can accomplish this, but is not usable in webservice processes since this shape is functional.