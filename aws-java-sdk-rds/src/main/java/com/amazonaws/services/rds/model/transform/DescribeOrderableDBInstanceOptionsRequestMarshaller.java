/*
 * Copyright 2011-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.rds.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.SdkClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.rds.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.IdempotentUtils;

/**
 * DescribeOrderableDBInstanceOptionsRequest Marshaller
 */

public class DescribeOrderableDBInstanceOptionsRequestMarshaller implements
        Marshaller<Request<DescribeOrderableDBInstanceOptionsRequest>, DescribeOrderableDBInstanceOptionsRequest> {

    public Request<DescribeOrderableDBInstanceOptionsRequest> marshall(DescribeOrderableDBInstanceOptionsRequest describeOrderableDBInstanceOptionsRequest) {

        if (describeOrderableDBInstanceOptionsRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        Request<DescribeOrderableDBInstanceOptionsRequest> request = new DefaultRequest<DescribeOrderableDBInstanceOptionsRequest>(
                describeOrderableDBInstanceOptionsRequest, "AmazonRDS");
        request.addParameter("Action", "DescribeOrderableDBInstanceOptions");
        request.addParameter("Version", "2014-10-31");
        request.setHttpMethod(HttpMethodName.POST);

        if (describeOrderableDBInstanceOptionsRequest.getEngine() != null) {
            request.addParameter("Engine", StringUtils.fromString(describeOrderableDBInstanceOptionsRequest.getEngine()));
        }

        if (describeOrderableDBInstanceOptionsRequest.getEngineVersion() != null) {
            request.addParameter("EngineVersion", StringUtils.fromString(describeOrderableDBInstanceOptionsRequest.getEngineVersion()));
        }

        if (describeOrderableDBInstanceOptionsRequest.getDBInstanceClass() != null) {
            request.addParameter("DBInstanceClass", StringUtils.fromString(describeOrderableDBInstanceOptionsRequest.getDBInstanceClass()));
        }

        if (describeOrderableDBInstanceOptionsRequest.getLicenseModel() != null) {
            request.addParameter("LicenseModel", StringUtils.fromString(describeOrderableDBInstanceOptionsRequest.getLicenseModel()));
        }

        if (describeOrderableDBInstanceOptionsRequest.getVpc() != null) {
            request.addParameter("Vpc", StringUtils.fromBoolean(describeOrderableDBInstanceOptionsRequest.getVpc()));
        }

        com.amazonaws.internal.SdkInternalList<Filter> filtersList = (com.amazonaws.internal.SdkInternalList<Filter>) describeOrderableDBInstanceOptionsRequest
                .getFilters();
        if (!filtersList.isEmpty() || !filtersList.isAutoConstruct()) {
            int filtersListIndex = 1;

            for (Filter filtersListValue : filtersList) {

                if (filtersListValue.getName() != null) {
                    request.addParameter("Filters.Filter." + filtersListIndex + ".Name", StringUtils.fromString(filtersListValue.getName()));
                }

                com.amazonaws.internal.SdkInternalList<String> valuesList = (com.amazonaws.internal.SdkInternalList<String>) filtersListValue.getValues();
                if (!valuesList.isEmpty() || !valuesList.isAutoConstruct()) {
                    int valuesListIndex = 1;

                    for (String valuesListValue : valuesList) {
                        if (valuesListValue != null) {
                            request.addParameter("Filters.Filter." + filtersListIndex + ".Values.Value." + valuesListIndex,
                                    StringUtils.fromString(valuesListValue));
                        }
                        valuesListIndex++;
                    }
                }
                filtersListIndex++;
            }
        }

        if (describeOrderableDBInstanceOptionsRequest.getMaxRecords() != null) {
            request.addParameter("MaxRecords", StringUtils.fromInteger(describeOrderableDBInstanceOptionsRequest.getMaxRecords()));
        }

        if (describeOrderableDBInstanceOptionsRequest.getMarker() != null) {
            request.addParameter("Marker", StringUtils.fromString(describeOrderableDBInstanceOptionsRequest.getMarker()));
        }

        return request;
    }

}
