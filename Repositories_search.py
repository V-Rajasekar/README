import sys

sys.path.append('./libs')
import requests


def search_text_in_repos(token, organization, search_text):
    headers = {
        "Authorization": f"Bearer {token}"
    }

    # Step 1: Get list of all repositories in the organization
    repos_url = f"https://api.github.com/orgs/{organization}/repos"
    response = requests.get(repos_url, headers=headers)
    repos = response.json()

    # Step 2 & 3: Search through each repository's contents for the text
    found_repos = []
    for repo in repos:
        contents_url = repo["contents_url"].replace("{+path}", "")
        contents_response = requests.get(contents_url, headers=headers)
        contents = contents_response.json()

        for content in contents:
            if content["type"] == "file":
                download_url = content["download_url"]
                file_content_response = requests.get(download_url, headers=headers)
                file_content = file_content_response.text
                if search_text in file_content:
                    found_repos.append(repo["name"])
                    break  # Break out of inner loop if text is found

    return found_repos

# Example usage
token = "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"
organization = "bring"
search_text = "agreement_register"

found_repos = search_text_in_repos(token, organization, search_text)
print("Repositories containing the text:", found_repos)
