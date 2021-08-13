// Copyright (c) 2021 Boomi, Inc.
package com.boomi.connector.document_tracker;

import com.boomi.connector.api.BrowseContext;
import com.boomi.connector.api.Browser;
import com.boomi.connector.api.Operation;
import com.boomi.connector.api.OperationContext;
import com.boomi.connector.document_tracker.operations.DocumentTrackerExecuteOperation;
import com.boomi.connector.util.BaseConnector;


public class DocumentTrackerConnector extends BaseConnector {

    @Override
    public Browser createBrowser(BrowseContext browseContext) {
        return null;
    }

    @Override
    protected Operation createExecuteOperation(OperationContext context) {
        return new DocumentTrackerExecuteOperation(context);
    };

}

