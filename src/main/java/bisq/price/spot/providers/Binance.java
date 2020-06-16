/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package bisq.price.spot.providers;

import bisq.price.spot.ExchangeRate;
import bisq.price.spot.ExchangeRateProvider;

import org.knowm.xchange.binance.BinanceExchange;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;

import java.util.Set;

@Component
@Order(5)
public class Binance extends ExchangeRateProvider {

    public Binance() {
        super("BINANCE", "binance", Duration.ofMinutes(1));
    }

    @Override
    public Set<ExchangeRate> doGet() {
        // Supported fiat: EUR, NGN, RUB, TRY, ZAR
        // Supported alts: BEAM, DASH, DCR, DOGE, ETC, ETH, LTC, NAV, PIVX, XMR, XZC, ZEC, ZEN
        return doGet(BinanceExchange.class);
    }
}
