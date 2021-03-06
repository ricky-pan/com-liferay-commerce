/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.service.impl;

import com.liferay.commerce.constants.CommerceActionKeys;
import com.liferay.commerce.constants.CommerceConstants;
import com.liferay.commerce.model.CommerceSubscriptionEntry;
import com.liferay.commerce.service.base.CommerceSubscriptionEntryServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.UnicodeProperties;

import java.util.List;

/**
 * @author Alessio Antonio Rendina
 */
public class CommerceSubscriptionEntryServiceImpl
	extends CommerceSubscriptionEntryServiceBaseImpl {

	@Override
	public void deleteCommerceSubscriptionEntry(
			long commerceSubscriptionEntryId)
		throws PortalException {

		CommerceSubscriptionEntry commerceSubscriptionEntry =
			commerceSubscriptionEntryLocalService.getCommerceSubscriptionEntry(
				commerceSubscriptionEntryId);

		_portletResourcePermission.check(
			getPermissionChecker(), commerceSubscriptionEntry.getGroupId(),
			CommerceActionKeys.MANAGE_COMMERCE_SUBSCRIPTIONS);

		commerceSubscriptionEntryLocalService.deleteCommerceSubscriptionEntry(
			commerceSubscriptionEntryId);
	}

	@Override
	public CommerceSubscriptionEntry fetchCommerceSubscriptionEntry(
			long commerceSubscriptionEntryId)
		throws PortalException {

		CommerceSubscriptionEntry commerceSubscriptionEntry =
			commerceSubscriptionEntryLocalService.
				fetchCommerceSubscriptionEntry(commerceSubscriptionEntryId);

		if (commerceSubscriptionEntry != null) {
			_portletResourcePermission.check(
				getPermissionChecker(), commerceSubscriptionEntry.getGroupId(),
				CommerceActionKeys.MANAGE_COMMERCE_SUBSCRIPTIONS);
		}

		return commerceSubscriptionEntry;
	}

	@Override
	public List<CommerceSubscriptionEntry> getCommerceSubscriptionEntries(
			long groupId, long userId, int start, int end,
			OrderByComparator<CommerceSubscriptionEntry> orderByComparator)
		throws PortalException {

		return commerceSubscriptionEntryLocalService.
			getCommerceSubscriptionEntries(
				groupId, userId, start, end, orderByComparator);
	}

	@Override
	public int getCommerceSubscriptionEntriesCount(long groupId, long userId)
		throws PortalException {

		return commerceSubscriptionEntryLocalService.
			getCommerceSubscriptionEntriesCount(groupId, userId);
	}

	@Override
	public BaseModelSearchResult<CommerceSubscriptionEntry>
			searchCommerceSubscriptionEntries(
				long companyId, long groupId, Long maxSubscriptionCycles,
				Integer subscriptionStatus, String keywords, int start, int end,
				Sort sort)
		throws PortalException {

		_portletResourcePermission.check(
			getPermissionChecker(), groupId,
			CommerceActionKeys.MANAGE_COMMERCE_SUBSCRIPTIONS);

		return commerceSubscriptionEntryLocalService.
			searchCommerceSubscriptionEntries(
				companyId, groupId, maxSubscriptionCycles, subscriptionStatus,
				keywords, start, end, sort);
	}

	@Override
	public CommerceSubscriptionEntry updateCommerceSubscriptionEntry(
			long commerceSubscriptionEntryId, int subscriptionLength,
			String subscriptionType,
			UnicodeProperties subscriptionTypeSettingsProperties,
			long maxSubscriptionCycles, int subscriptionStatus,
			int startDateMonth, int startDateDay, int startDateYear,
			int startDateHour, int startDateMinute, int nextIterationDateMonth,
			int nextIterationDateDay, int nextIterationDateYear,
			int nextIterationDateHour, int nextIterationDateMinute)
		throws PortalException {

		CommerceSubscriptionEntry commerceSubscriptionEntry =
			commerceSubscriptionEntryLocalService.getCommerceSubscriptionEntry(
				commerceSubscriptionEntryId);

		_portletResourcePermission.check(
			getPermissionChecker(), commerceSubscriptionEntry.getGroupId(),
			CommerceActionKeys.MANAGE_COMMERCE_SUBSCRIPTIONS);

		return commerceSubscriptionEntryLocalService.
			updateCommerceSubscriptionEntry(
				commerceSubscriptionEntryId, subscriptionLength,
				subscriptionType, subscriptionTypeSettingsProperties,
				maxSubscriptionCycles, subscriptionStatus, startDateMonth,
				startDateDay, startDateYear, startDateHour, startDateMinute,
				nextIterationDateMonth, nextIterationDateDay,
				nextIterationDateYear, nextIterationDateHour,
				nextIterationDateMinute);
	}

	@Override
	public CommerceSubscriptionEntry updateSubscriptionStatus(
			long commerceSubscriptionEntryId, int subscriptionStatus)
		throws PortalException {

		CommerceSubscriptionEntry commerceSubscriptionEntry =
			commerceSubscriptionEntryLocalService.getCommerceSubscriptionEntry(
				commerceSubscriptionEntryId);

		_portletResourcePermission.check(
			getPermissionChecker(), commerceSubscriptionEntry.getGroupId(),
			CommerceActionKeys.MANAGE_COMMERCE_SUBSCRIPTIONS);

		return commerceSubscriptionEntryLocalService.updateSubscriptionStatus(
			commerceSubscriptionEntryId, subscriptionStatus);
	}

	private static volatile PortletResourcePermission
		_portletResourcePermission =
			PortletResourcePermissionFactory.getInstance(
				CommerceSubscriptionEntryServiceImpl.class,
				"_portletResourcePermission", CommerceConstants.RESOURCE_NAME);

}