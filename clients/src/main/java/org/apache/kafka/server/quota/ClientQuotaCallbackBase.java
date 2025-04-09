/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.kafka.server.quota;

public interface ClientQuotaCallbackBase extends ClientQuotaCallback {

    /**
     * This callback is invoked whenever there are changes in the cluster metadata, such as
     * brokers being added or removed, topics being created or deleted, or partition leadership updates.
     * This is useful if quota computation takes partitions into account.
     * Topics that are being deleted will not be included in `cluster`.
     *
     * @param clusterMetadata Cluster metadata including partitions and their leaders if known
     * @return true if quotas have changed and metric configs may need to be updated
     */
    boolean updateClusterMetadata(ClusterMetadata clusterMetadata);
}
