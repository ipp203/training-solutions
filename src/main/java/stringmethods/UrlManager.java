package stringmethods;

//protocol://host:port/path?query-string
public class UrlManager {
    private String protocol, host, path, query;
    private Integer port;
    private int protocolIndex, hostIndex, portIndex, pathIndex;


    public UrlManager(String url) {
        if (isEmptyString(url)) {
            throw new IllegalArgumentException("Invalid url");
        }

        protocol = getProtocolFromUrl(url);
        host = getHostFromUrl(url);
        port = getPortFromUrl(url);
        path = getPathFromUrl(url);
        query = getQueryFromUrl(url);
    }

    public String getProtocol() {
        return protocol;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public Integer getPort() {
        return port;
    }

    public boolean hasProperty(String key) {
        if (isEmptyString(key)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        if (isEmptyString(query)) {
            return false;
        }
        String[] queryKeys = getQueryKeys(query);

        boolean result = false;
        for (String s : queryKeys) {
            if (key.equals(s)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public String getProperty(String key) {
        if (hasProperty(key)) {
            String[] queryKeys = getQueryKeys(query);
            String[] queryValues = getQueryValues(query);

            String result = "";
            for (int i = 0; i < queryKeys.length; i++) {
                if (key.equals(queryKeys[i])) {
                    result = queryValues[i];
                }
            }
            return result;
        } else {
            return null;
        }
    }

    private String[] getQueryKeys(String query) {
        String[] keys = query.split("&");
        for (int i = 0; i < keys.length; i++) {
            keys[i] = keys[i].substring(0, keys[i].indexOf('='));
        }
        return keys;
    }

    private String[] getQueryValues(String query) {
        String[] keys = query.split("&");
        for (int i = 0; i < keys.length; i++) {
            keys[i] = keys[i].substring(keys[i].indexOf('=') + 1);
        }
        return keys;
    }

    private String getProtocolFromUrl(String url) {
        protocolIndex = url.indexOf("://");
        if (protocolIndex < 0) {
            throw new IllegalArgumentException("Invalid url");
        }
        return url.substring(0, protocolIndex).toLowerCase();
    }

    private String getHostFromUrl(String url) {
        int protocolEndIndex = protocolIndex + "://".length();
        int i1 = url.indexOf(':', protocolEndIndex);
        int i2 = url.indexOf('/', protocolEndIndex);

        hostIndex = i1 > 0 ? i1 : i2;

        if (hostIndex < 0) {
            throw new IllegalArgumentException("Invalid url");
        }
        return url.substring(protocolEndIndex, hostIndex).toLowerCase();
    }

    private Integer getPortFromUrl(String url) {
        portIndex = hostIndex;
        if (url.charAt(hostIndex) == ':') {
            String s;
            if (url.indexOf('/', hostIndex) >= 0) {
                s = url.substring(hostIndex + 1, url.indexOf('/', hostIndex));
            } else {
                s = url.substring(hostIndex + 1);
            }
            portIndex = hostIndex + 1 + s.length();
            return Integer.parseInt(s);
        } else {
            return null;
        }
    }

    private String getPathFromUrl(String url) {
        pathIndex = Math.max(portIndex, url.indexOf('?', portIndex));
        return url.substring(portIndex, pathIndex);
    }

    private String getQueryFromUrl(String url) {
        return url.substring(Math.min(url.length(), pathIndex + 1));
    }

    private boolean isEmptyString(String str) {
        return (str == null || "".equals(str.trim()));
    }
}
