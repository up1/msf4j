/*
 *  Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.wso2.msf4j.client.test.exception;

import org.wso2.msf4j.client.test.model.ServiceErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * ExceptionMapper which handles InvoiceNotFoundException.
 */
public class InvoiceNotFoundMapper implements ExceptionMapper<InvoiceNotFoundException> {

    private static final String ERROR_CODE = "30002";

    public Response toResponse(InvoiceNotFoundException ex) {
        return Response.status(404)
                .entity(new ServiceErrorResponse(ERROR_CODE, ex.getMessage()))
                .type("text/plain")
                .build();
    }
}