package github;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedIterable;

public class GitHubUserRepositoriesDownloader
{
    private static List<String> userNames;
    
    
    private static void initialiseListOfGitHubUsers()
    {
        userNames = new ArrayList<String>();
        
        userNames.add("8thlight");
        userNames.add("500px");
        userNames.add("2359media");
        userNames.add("3pillarlabs");
        userNames.add("99designs");
        userNames.add("Accenture");
        userNames.add("acntech");
        userNames.add("AdRoll");
        userNames.add("adzerk");
        userNames.add("adzerk-oss");
        userNames.add("akamai");
        userNames.add("akamai-open");
        userNames.add("airbnb");
        userNames.add("algolia");
        userNames.add("alibaba");
        userNames.add("allegro");
        userNames.add("alphagov");
        userNames.add("alphasights");
        userNames.add("amd");
        userNames.add("angular-ui");
        userNames.add("apache");
        userNames.add("arabiaweather");
        userNames.add("artsy");
        userNames.add("Asana");
        userNames.add("ASUS-US");
        userNames.add("atlassian");
        userNames.add("auth0");
        userNames.add("autodesk-cloud");
        userNames.add("aweber");
        userNames.add("aws");
        userNames.add("awslabs");
        userNames.add("azavea");
        userNames.add("Azure");
        userNames.add("badoo");
        userNames.add("bazaarvoice");
        userNames.add("bbc");
        userNames.add("bbcarchdev");
        userNames.add("bbc-fm-nk-core-eng");
        userNames.add("bbc-frameworks");
        userNames.add("BBC-News");
        userNames.add("bbcrd");
        userNames.add("bigcommerce");
        userNames.add("bitly");
        userNames.add("bittorrent");
        userNames.add("bittorrenttorque");
        userNames.add("blablacar");
        userNames.add("Blizzard");
        userNames.add("bloomreach");
        userNames.add("BrandwatchLtd");
        userNames.add("Brownplt");
        userNames.add("brownsys");
        userNames.add("Brown-University-Library");
        userNames.add("buglabs");
        userNames.add("bukalapak");
        userNames.add("buzzfeed");
        userNames.add("BuzzFeedNews");
        userNames.add("CA-APM");
        userNames.add("CAGovOps");
        userNames.add("cambridgeuniversity");
        userNames.add("carbonfive");
        userNames.add("CastawayLabs");
        userNames.add("CA-ReleaseAutomation");
        userNames.add("CATechnologies");
        userNames.add("cdlib");
        userNames.add("CERN");
        userNames.add("cernbox");
        userNames.add("cerndb");
        userNames.add("CERNDocumentServer");
        userNames.add("cerner");
        userNames.add("cernops");
        userNames.add("cernvm");
        userNames.add("cf-platform-eng");
        userNames.add("chartbeat");
        userNames.add("cisco");
        userNames.add("CiscoCloud");
        userNames.add("CiscoDevNet");
        userNames.add("cisco-open-source");
        userNames.add("CiscoSystems");
        userNames.add("CiscoVE");
        userNames.add("citrix");
        userNames.add("citrix-research");
        userNames.add("clang-omp");
        userNames.add("closureplease");
        userNames.add("cloudera");
        userNames.add("cloudflare");
        userNames.add("cloudnativeapps");
        userNames.add("ClusterHQ");
        userNames.add("Codecademy");
        userNames.add("codecombat");
        userNames.add("codesync");
        userNames.add("Cognifide");
        userNames.add("columbia");
        userNames.add("confluentinc");
        userNames.add("coursera");
        userNames.add("crashlytics");
        userNames.add("criteo");
        userNames.add("criteo-forks");
        userNames.add("crossgovernmentservices");
        userNames.add("cul");
        userNames.add("cul-it");
        userNames.add("dailymotion");
        userNames.add("Dash-Labs");
        userNames.add("databricks");
        userNames.add("datacenter");
        userNames.add("datarank");
        userNames.add("deferpanic");
        userNames.add("DeloitteDigital");
        userNames.add("Deloitte-VA");
        userNames.add("developerforce");
        userNames.add("Deveo");
        userNames.add("DhDeveloper");
        userNames.add("digitalocean");
        userNames.add("DigitasLBi");
        userNames.add("DigitasLBi-SE-TechnologyLab");
        userNames.add("disqus");
        userNames.add("docker");
        userNames.add("DockerEnvy");
        userNames.add("docker-infra");
        userNames.add("docker-library");
        userNames.add("DockerPool");
        userNames.add("dockerstack");
        userNames.add("DotedLabs");
        userNames.add("do-community");
        userNames.add("dropbox");
        userNames.add("duke-libraries");
        userNames.add("DynamicsCRM");
        userNames.add("ea-cm");
        userNames.add("eBay");
        userNames.add("ebaylabs");
        userNames.add("eclipse");
        userNames.add("efounders");
        userNames.add("eHarmony");
        userNames.add("electronicarts");
        userNames.add("embedly");
        userNames.add("engineyard");
        userNames.add("envato");
        userNames.add("epsilonlabs");
        userNames.add("Ericsson");
        userNames.add("EricssonResearch");
        userNames.add("esa");
        userNames.add("EspressoLogicCafe");
        userNames.add("etsy");
        userNames.add("eventbrite");
        userNames.add("evernote");
        userNames.add("EverythingMe");
        userNames.add("ExactTarget");
        userNames.add("Expedia-CSE");
        userNames.add("ExpediaDotCom");
        userNames.add("facebook");
        userNames.add("facebookarchive");
        userNames.add("facebookgo");
        userNames.add("facebooknuclide");
        userNames.add("fastly");
        userNames.add("FiftyThree");
        userNames.add("filestack");
        userNames.add("firebase");
        userNames.add("firmafon");
        userNames.add("flickr");
        userNames.add("Flipboard");
        userNames.add("Flipkart");
        userNames.add("flipkart-incubator");
        userNames.add("fmtvp");
        userNames.add("fogbeam");
        userNames.add("FormidableLabs");
        userNames.add("foursquare");
        userNames.add("FujitsuEnablingSoftwareTechnologyGmbH");
        userNames.add("FutureProcessing");
        userNames.add("fuww");
        userNames.add("getsentry");
        userNames.add("gilt");
        userNames.add("github");
        userNames.add("gnip");
        userNames.add("godaddy");
        userNames.add("google");
        userNames.add("googleanalytics");
        userNames.add("GoogleChrome");
        userNames.add("GoogleCloudPlatform");
        userNames.add("GoogleCodeIn");
        userNames.add("googlecodelabs");
        userNames.add("GoogleDeveloperExperts");
        userNames.add("googledrive");
        userNames.add("googlegenomics");
        userNames.add("googlei18n");
        userNames.add("googlemaps");
        userNames.add("GoogleTrends");
        userNames.add("GoogleWebComponentAll");
        userNames.add("GoogleWebComponents");
        userNames.add("google-web-toolkit");
        userNames.add("gosquared");
        userNames.add("Govexec");
        userNames.add("Grouper");
        userNames.add("groupon");
        userNames.add("groupon-open-source");
        userNames.add("guardian");
        userNames.add("gusrc");
        userNames.add("HackerEarth");
        userNames.add("Harvard-ATG");
        userNames.add("harvard-crimson");
        userNames.add("HarvardEconCS");
        userNames.add("harvard-lil");
        userNames.add("harvesthq");
        userNames.add("hashrocket");
        userNames.add("HBRGTech");
        userNames.add("hcs");
        userNames.add("heroku");
        userNames.add("HewlettPackard");
        userNames.add("Hewlett-Packard-ESS");
        userNames.add("Hinge");
        userNames.add("hired");
        userNames.add("hmdc");
        userNames.add("hms-dbmi");
        userNames.add("hootsuite");
        userNames.add("HubSpot");
        userNames.add("hubspotdevops");
        userNames.add("Huddle");
        userNames.add("huit");
        userNames.add("hyperstudio");
        userNames.add("IBM-Bluemix");
        userNames.add("ibm-cds-labs");
        userNames.add("ibm-cloud");
        userNames.add("ibm-datapower");
        userNames.add("ibm-et");
        userNames.add("ibm-informix");
        userNames.add("ibm-js");
        userNames.add("IBMPredictiveAnalytics");
        userNames.add("ibm-security-intelligence");
        userNames.add("IBMStreams");
        userNames.add("IBM-Watson");
        userNames.add("IFTTT");
        userNames.add("imgix");
        userNames.add("Imgur");
        userNames.add("imvu");
        userNames.add("instacart");
        userNames.add("instagram");
        userNames.add("Intel");
        userNames.add("Intel-bigdata");
        userNames.add("intel-hadoop");
        userNames.add("IntelLabs");
        userNames.add("intelsdi-x");
        userNames.add("intuit");
        userNames.add("intuit-archive");
        userNames.add("IntuitDeveloper");
        userNames.add("iteleport");
        userNames.add("javascriptu");
        userNames.add("jquery");
        userNames.add("justeat");
        userNames.add("keen");
        userNames.add("keenlabs");
        userNames.add("Khan");
        userNames.add("kickstarter");
        userNames.add("kifi");
        userNames.add("klout");
        userNames.add("larvalabs");
        userNames.add("linkedin");
        userNames.add("livechat");
        userNames.add("livingsocial");
        userNames.add("LivotovLabs");
        userNames.add("localytics");
        userNames.add("lookout");
        userNames.add("lyft");
        userNames.add("mailchimp");
        userNames.add("mailgun");
        userNames.add("MarketplaceUX");
        userNames.add("MaxCDN");
        userNames.add("mdn");
        userNames.add("Medium");
        userNames.add("meetup");
        userNames.add("Microsoft");
        userNames.add("MicrosoftDX");
        userNames.add("MicrosoftEdge");
        userNames.add("MicrosoftResearch");
        userNames.add("misd-service-development");
        userNames.add("mit-athena");
        userNames.add("MITLibraries");
        userNames.add("mixmaxhq");
        userNames.add("mixpanel");
        userNames.add("mlibrary");
        userNames.add("MMIL");
        userNames.add("monetate");
        userNames.add("moneybird");
        userNames.add("motirolabs");
        userNames.add("mozilla");
        userNames.add("Mozilla-cIT");
        userNames.add("mozillascience");
        userNames.add("MozillaSecurity");
        userNames.add("mozilla-services");
        userNames.add("MozRelOps");
        userNames.add("mspfe");
        userNames.add("mulesoft-labs");
        userNames.add("musixmatch");
        userNames.add("Musixmatchdev");
        userNames.add("MusixmatchHacks");
        userNames.add("mwrlabs");
        userNames.add("myntra");
        userNames.add("nebula-plugins");
        userNames.add("Netflix");
        userNames.add("NetflixMicroservices");
        userNames.add("NetflixUI");
        userNames.add("newrelic");
        userNames.add("niclabs");
        userNames.add("npm-flickr");
        userNames.add("NVIDIA");
        userNames.add("NVlabs");
        userNames.add("NYTimes");
        userNames.add("okta");
        userNames.add("omniti-labs");
        userNames.add("opendns");
        userNames.add("opengovernment");
        userNames.add("opengovplatform");
        userNames.add("opentable");
        userNames.add("opf-labs");
        userNames.add("optimizely");
        userNames.add("oracle");
        userNames.add("OracleLabs");
        userNames.add("OSTC");
        userNames.add("OUP");
        userNames.add("oursky");
        userNames.add("ox-it");
        userNames.add("palominolabs");
        userNames.add("ParsePlatform");
        userNames.add("paypal");
        userNames.add("pinterest");
        userNames.add("pinterest-web");
        userNames.add("pitchfork");
        userNames.add("pivotal");
        userNames.add("Pivotal-DataFabric");
        userNames.add("Pivotal-Field-Engineering");
        userNames.add("pivotalsoftware");
        userNames.add("pivotaltracker");
        userNames.add("piwik");
        userNames.add("plum-umd");
        userNames.add("polyvore");
        userNames.add("prezi");
        userNames.add("Prismatic");
        userNames.add("producthunt");
        userNames.add("pulibrary");
        userNames.add("put-poznan");
        userNames.add("Quora-Users");
        userNames.add("rackerlabs");
        userNames.add("Raizlabs");
        userNames.add("rdio");
        userNames.add("Reactive-Extensions");
        userNames.add("redbubble");
        userNames.add("RedisLabs");
        userNames.add("relateiq");
        userNames.add("remindcloud");
        userNames.add("rightscale");
        userNames.add("RisingStack");
        userNames.add("Runscope");
        userNames.add("SalesforceDevelopersJapan");
        userNames.add("SalesforceEng");
        userNames.add("SalesforceFoundation");
        userNames.add("salesforceidentity");
        userNames.add("salesforce-it");
        userNames.add("salesforce-marketingcloud");
        userNames.add("salesforce-ux");
        userNames.add("SAP");
        userNames.add("sapbuild");
        userNames.add("sapient-global");
        userNames.add("SapientNitroLA");
        userNames.add("sapientnitrolondon");
        userNames.add("SapientNYC");
        userNames.add("Sapphirine");
        userNames.add("scalextremeinc");
        userNames.add("sendgrid");
        userNames.add("sendgridlabs");
        userNames.add("senseobservationsystems");
        userNames.add("serverless");
        userNames.add("sharethis");
        userNames.add("sharethis-github");
        userNames.add("sharethrough");
        userNames.add("Shopify");
        userNames.add("siqueries");
        userNames.add("siemens");
        userNames.add("slackhq");
        userNames.add("smartcat-labs");
        userNames.add("socialcast");
        userNames.add("songkick");
        userNames.add("soundcloud");
        userNames.add("soundcloudlabs");
        userNames.add("spotify");
        userNames.add("spring-labs");
        userNames.add("spring-projects");
        userNames.add("StackExchange");
        userNames.add("stormpath");
        userNames.add("storyful");
        userNames.add("strava");
        userNames.add("stripe");
        userNames.add("su-et");
        userNames.add("sul-dlss");
        userNames.add("SurveyMonkey");
        userNames.add("Symantec");
        userNames.add("takipi");
        userNames.add("taskrabbit");
        userNames.add("techcrunch");
        userNames.add("technology-ebay-de");
        userNames.add("teespring");
        userNames.add("TeespringLabs");
        userNames.add("TheGiftsProject");
        userNames.add("TheRandomLabs");
        userNames.add("thoughtbot");
        userNames.add("thoughtworks");
        userNames.add("ThoughtWorksInc");
        userNames.add("ThoughtWorksStudios");
        userNames.add("thumbtack");
        userNames.add("Ticketmaster");
        userNames.add("timehop");
        userNames.add("tokopedia");
        userNames.add("transferwise");
        userNames.add("trello");
        userNames.add("tripadvisor");
        userNames.add("trivago");
        userNames.add("tumblr");
        userNames.add("tupilabs");
        userNames.add("twilio");
        userNames.add("twitter");
        userNames.add("twitterdev");
        userNames.add("twitter-fabric");
        userNames.add("twitter-forks");
        userNames.add("twitter-university");
        userNames.add("Typeform");
        userNames.add("ualibweb");
        userNames.add("uber");
        userNames.add("ucam-cl-dtg");
        userNames.add("uchicago");
        userNames.add("UCL");
        userNames.add("udemy");
        userNames.add("ulsdevteam");
        userNames.add("umd-lib");
        userNames.add("umiami-web-design");
        userNames.add("umiso");
        userNames.add("UniconLabs");
        userNames.add("unikent");
        userNames.add("UniOfGreenwich");
        userNames.add("universityofderby");
        userNames.add("UniversityofWarwick");
        userNames.add("university-of-york");
        userNames.add("UniversityRadioYork");
        userNames.add("UoMCS");
        userNames.add("uploadcare");
        userNames.add("usnistgov");
        userNames.add("UTN-FRD");
        userNames.add("uWaterloo");
        userNames.add("Vela");
        userNames.add("venmo");
        userNames.add("vigetlabs");
        userNames.add("vine");
        userNames.add("vinted");
        userNames.add("vmware");
        userNames.add("vmwaredevcenter");
        userNames.add("vngrs");
        userNames.add("VodafoneAustralia");
        userNames.add("washingtonstateuniversity");
        userNames.add("Wattpad");
        userNames.add("wayfair");
        userNames.add("wealthfront");
        userNames.add("weareswat");
        userNames.add("WebbyLab");
        userNames.add("wesovilabs");
        userNames.add("where");
        userNames.add("wimbu");
        userNames.add("wingify");
        userNames.add("wix");
        userNames.add("www-thoughtworks-com");
        userNames.add("ximenzi");
        userNames.add("xing");
        userNames.add("yahoo");
        userNames.add("yahoojapan");
        userNames.add("Yalantis");
        userNames.add("yammer");
        userNames.add("ydn");
        userNames.add("Yelp");
        userNames.add("YelpArchive");
        userNames.add("youtube");
        userNames.add("zalando");
        userNames.add("zendesk");
        userNames.add("zendesklabs");
        userNames.add("zenefits");
        userNames.add("zillow");
        userNames.add("zulily");
        userNames.add("zumba");
        userNames.add("zynga");
        
        Collections.sort(userNames);
    }
    
    
    /*public static void main(String[] args)
    {
        initialiseListOfGitHubUsers();
        GitHub github = null;
        
        try
        {
            //github = GitHub.connectAnonymously();
            github = GitHub.connectUsingPassword("efthymiou.dimitrios1@gmail.com", "bunkzh3Z");
            Path file = FileSystems.getDefault().getPath("D:\\temp\\RepositoriesDownloadedFromGitHub.txt");
            
            for(String userName : userNames)
            {
                try
                {
                    GHUser user = github.getUser(userName);
                    
                    if(user != null)
                    {
                        PagedIterable<GHRepository> userRepositories = user.listRepositories();
                        
                        if(userRepositories != null)
                        {
                            for(GHRepository userRepository : userRepositories.asList())
                            {
                                byte[] bytes = null;

                                String downloadURL = userRepository.getHtmlUrl().toString() + "\n";
                                bytes = downloadURL.getBytes();

                                try
                                {
                                    Files.write(file, bytes, StandardOpenOption.APPEND);
                                }
                                catch(IOException e)
                                {
                                    System.out.println(e);
                                }
                            }
                        }
                    }
                    else
                    {
                        System.out.println(userName + " -- does not exist");
                    }
                }
                catch(IOException exception)
                {
                    exception.printStackTrace();
                }
            }
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }*/
    
    
    public static void main(String[] args)
    {
        Path repositoriesLinksFile = FileSystems.getDefault().getPath("D:\\temp\\RepositoriesDownloadedFromGitHub.txt");
        Path downloadLinksFile = FileSystems.getDefault().getPath("D:\\temp\\GitHubRepositoriesDownloadLinks.txt");
        
        try
        {
            List<String> repositoriesLinks = Files.readAllLines(repositoriesLinksFile);
            
            for(String repositoryLink : repositoriesLinks)
            {
                byte[] bytes = null;

                String downloadURL = repositoryLink + "/archive/master.zip\n";
                bytes = downloadURL.getBytes();

                try
                {
                    Files.write(downloadLinksFile, bytes, StandardOpenOption.APPEND);
                }
                catch(IOException e)
                {
                    System.out.println(e);
                }
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}