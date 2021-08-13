// Copyright (c) 2021 Boomi, Inc.
package com.boomi.connector.document_tracker.operations;

import com.boomi.connector.api.*;
import com.boomi.connector.util.BaseUpdateOperation;
import com.boomi.util.IOUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class DocumentTrackerExecuteOperation extends BaseUpdateOperation {

    public DocumentTrackerExecuteOperation(OperationContext context) {
        super(context);
    }

    protected void executeUpdate(UpdateRequest updateRequest, OperationResponse operationResponse) {
        for (final ObjectData input : updateRequest) {
            operationResponse.addResult(input,
                    OperationStatus.SUCCESS,
                    "OK",
                    "OK",
                    new Payload() {

                        private InputStream _data;

                        @Override
                        public InputStream readFrom() throws IOException {
                            _data = input.getData();
                            return _data;
                        }

                        @Override
                        public void close() throws IOException {
                            IOUtil.closeQuietly(_data);
                        }

                        @Override
                        public void writeTo(OutputStream arg0) throws IOException {
                            throw new UnsupportedOperationException();
                        }

                    });
        }
    }
}
